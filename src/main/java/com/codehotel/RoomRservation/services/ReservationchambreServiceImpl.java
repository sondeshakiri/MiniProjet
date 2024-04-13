package com.codehotel.RoomRservation.services;


import com.codehotel.RoomRservation.model.DateRange;

import com.codehotel.RoomRservation.model.Reservation;
import com.codehotel.RoomRservation.model.Room;
import com.codehotel.RoomRservation.model.RoomReservation;
import com.codehotel.RoomRservation.model.RoomReservationRequest;
import com.codehotel.RoomRservation.model.RservationStatus;
import com.codehotel.RoomRservation.model.User;
import com.codehotel.RoomRservation.repository.ReservationRepository;
import com.codehotel.RoomRservation.repository.RoomRepository;
import com.codehotel.RoomRservation.repository.RoomReservationRepository;
import com.codehotel.RoomRservation.repository.UserRepository;
import com.codehotel.RoomRservation.repository.dateRangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class ReservationchambreServiceImpl implements ReservationchambreService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private dateRangeRepository dateRangeRepository;
    @Autowired
    private RoomReservationRepository roomReservationRepository;
    
    
 

	@Override
	public List<Room> searchAvailableRoomm(Date startDate, Date endDate, int capacity) {
	    List<Room> availableRooms = new ArrayList<>();

	    // Récupérer les chambres qui ont une capacité supérieure à la capacité saisie
	    List<Room> roomsWithSufficientCapacity = roomRepository.findByCapacityGreaterThanEqual(capacity);
	   

	    // Parcourir les chambres avec une capacité suffisante
	    for (Room room : roomsWithSufficientCapacity) {
	        // Récupérer les plages de dates pour cette chambre
	        List<DateRange> dateRanges = room.getDaterange();

	        // Vérifier si la chambre est disponible pour les dates spécifiées
	        boolean isAvailable = true;
	        for (DateRange dateRange : dateRanges) {
	            // Vérifier si la date de début est incluse dans une plage de dates réservée
	            if (startDate.compareTo(dateRange.getStartDate()) >= 0 && startDate.compareTo(dateRange.getEndDate()) <= 0) {
	                isAvailable = false;
	                break;
	            }

	            // Vérifier si la date de fin est incluse dans une plage de dates réservée
	            if (endDate.compareTo(dateRange.getStartDate()) >= 0 && endDate.compareTo(dateRange.getEndDate()) <= 0) {
	                isAvailable = false;
	                break;
	            }

	            // Vérifier si la plage de dates spécifiée chevauche une plage de dates réservée
	            if (startDate.compareTo(dateRange.getStartDate()) <= 0 && endDate.compareTo(dateRange.getEndDate()) >= 0) {
	                isAvailable = false;
	                break;
	            }
	        }
	        // Si la chambre est disponible, l'ajouter à la liste des chambres disponibles
	        if (isAvailable) {
	            availableRooms.add(room);
	        }
	        else {
	    	    System.out.println("mou9arna mal9at chy ");

	        }
	    }

	    return availableRooms;
	}



	@Transactional
	@Override
	public boolean reserveRoom(RoomReservationRequest request, Long userId) {
	    // Récupération de la chambre
	    Room room = roomRepository.findById(request.getRoomId()).orElse(null);
	    if (room == null) {
	        System.out.println("Room not found");
	        return false;
	    }
	    DateRange dateRangeToRemove = request.getDateRange();

	    // Suppression de la date saisie par l'utilisateur de la table DateRange
	    if (dateRangeToRemove != null) {
	        List<DateRange> dateRangesToRemove = dateRangeRepository.findByRoomIdAndStartDateAndEndDate(
	            request.getRoomId(),
	            dateRangeToRemove.getStartDate(),
	            dateRangeToRemove.getEndDate()
	        );
	        
	        if (dateRangesToRemove != null && !dateRangesToRemove.isEmpty()) {
	            System.out.println(dateRangesToRemove);
	            dateRangeRepository.deleteAll(dateRangesToRemove);
	        } else {
	            System.out.println("No matching DateRange found");
	            return false;
	        }
	    }

	    // Création d'une nouvelle réservation
	    Reservation reservation = new Reservation();
	    reservation.setStartDate(dateRangeToRemove.getStartDate());
	    reservation.setEndDate(dateRangeToRemove.getEndDate());
	    reservation.setRservationStatus(RservationStatus.CONFIRMED);
	    reservation.setIdReservation(generatereservationId());

	    // Récupération de l'utilisateur
	    User user = userRepository.findById(userId).orElse(null);
	    if (user == null) {
	        System.out.println("User not found");
	        return false;
	    }
	    reservation.setUser(user);

	    // Sauvegarde de la réservation
	    reservation = reservationRepository.save(reservation);
	    
	    // Création de la relation RoomReservation
	    RoomReservation roomReservation = new RoomReservation();
	    roomReservation.setRoom(room);
	    roomReservation.setReservation(reservation);
	    roomReservation.setCreationDate(new Date()); 

	    // Sauvegarde de la relation RoomReservation
	    //roomReservationRepository.save(roomReservation);

	    return true;
	}

	

    
    private int generatereservationId() {
        long totalUsers = reservationRepository.count();
        // Générez un identifiant unique en ajoutant 1 au nombre total d'utilisateurs
        return (int) totalUsers *15;
    }

    
    

   

    
}

