package priv.dev.bot.utils;

import org.springframework.stereotype.Component;
import priv.dev.bot.controllers.MessageController;
import priv.dev.bot.model.Status;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ControllerStorage {
    private final Map<Status, Class> map;

    public ControllerStorage() {
        this.map = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        List<Class> classes = null;
        try {
            classes = getClasses("priv.dev.bot.controllers");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Class clazz : classes) {
            try {
                Status status = (Status) clazz.getField("STATUS").get(null);
                map.put(status, clazz);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public Class getController(Status status) {
        return map.get(status);
    }

    private List<Class> getClasses(String packageName)
            throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            throw new RuntimeException("Class loader is null");
        }
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return filterControllers(classes);
    }

    private List<Class> filterControllers(List<Class> classes) {
        return classes.stream().filter(clazz -> clazz.getSuperclass().equals(MessageController.class)).collect(Collectors.toList());
    }

    private List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().contains(".")) {
                        throw new RuntimeException("File name shouldn't consist point.");
                    }
                    classes.addAll(findClasses(file, packageName + "."
                            + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName + '.'
                            + file.getName().substring(0, file.getName().length() - 6)));
                }
            }
        }
        return classes;
    }
}
