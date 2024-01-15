package io.github.kimmy.framework.cutscene;

import java.util.List;
import java.util.Optional;

public interface CutsceneRepository {
    boolean add(Cutscene cutscene);
    boolean remove(Cutscene cutscene);
    Optional<Cutscene> findById(String uniqueId);
    Optional<Cutscene> findByName(String name);
    List<Cutscene> findAll();
    void clear();
}
