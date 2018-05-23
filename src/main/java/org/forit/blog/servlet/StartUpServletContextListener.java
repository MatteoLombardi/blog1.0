package org.forit.blog.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.forit.blog.entity.EntityManagerProvider;

public class StartUpServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerProvider.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerProvider.destroy();
    }
}
