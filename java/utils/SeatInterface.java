package utils;

import model.Seat;
import model.State;

import java.util.List;

public interface SeatInterface {
    public List<State> getAllSeats();
    public Seat getSeatId(int seatId);
    public void updateSeat(Seat seats);
    public void deleteSeat(int seatId);
}
