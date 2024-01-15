package io.github.kimmy.framework.cutscene;

import io.github.kimmy.base.core.Main;

import java.util.*;

public class MemoryCutsceneRepository implements CutsceneRepository {

    private final Main plugin;
    private final Map<String, Cutscene> repository = new HashMap<>();

    public MemoryCutsceneRepository(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean add(Cutscene cutscene) {
        return (repository.putIfAbsent(cutscene.getUniqueId(), cutscene) == null);
    }

    @Override
    public boolean remove(Cutscene cutscene) {
        return repository.remove(cutscene.getUniqueId(), cutscene);
    }

    @Override
    public Optional<Cutscene> findById(String uniqueId) {
        return Optional.ofNullable(repository.get(uniqueId));
    }

    @Override
    public Optional<Cutscene> findByName(String name) {
        return repository.values().stream()
                .filter(cutscene -> cutscene.getCutsceneObject().getName().equals(name))
                .findAny();
    }

    @Override
    public List<Cutscene> findAll() {
        return new ArrayList<>(repository.values());
    }

    public Main getPlugin() {
        return plugin;
    }
}
