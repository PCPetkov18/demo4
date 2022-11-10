package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;
    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting Player 4: {}",dao.insertPlayer( new Player(4, "Thiem", "Austria", new Date(System.currentTimeMillis()),17)));

        dao.createTournamentTable();

        logger.info("French Players: {}", dao.getPlayerByNationality("France") );

        logger.info("All Players Data: {}",dao.getAllPlayers());
    }
}