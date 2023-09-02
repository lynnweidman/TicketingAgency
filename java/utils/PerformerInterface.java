package utils;

import model.Performer;
import java.util.List;

public interface PerformerInterface {
    public List<Performer> getAllPerformers();
    public Performer getPerformer(int performerId);
    public void updatePerformer(Performer performer);
    public void deletePerformer(int performerId);
}
