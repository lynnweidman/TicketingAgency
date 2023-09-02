package utils;

import model.Participates;
import java.util.List;

public interface ParticipatesInterface {
    public List<Participates> getAllParticipates();
    public Participates getParticipatesId(int participatesId);
    public void updateParticipates(Participates participates);
    public void deleteParticipates(int participatesId);
}
