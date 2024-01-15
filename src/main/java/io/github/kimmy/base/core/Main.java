package io.github.kimmy.base.core;

import io.github.kimmy.framework.cutscene.CutsceneRepository;
import io.github.kimmy.framework.cutscene.MemoryCutsceneRepository;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private CutsceneRepository cutsceneRepository;

    @Override
    public void onEnable() {
        cutsceneRepository = new MemoryCutsceneRepository(this);
    }

    public CutsceneRepository getCutsceneRepository() {
        return cutsceneRepository;
    }
}