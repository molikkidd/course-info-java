package com.pluralsight.courseinfo.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;

public class CourseRetriever {
//    add logger
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args) {
        LOG.info("Course Retriever starting");

        if(args.length == 0 ) {
            LOG.info("Please provide an author name as first arguement.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch(Exception e) {
            System.out.println("Unexpected error");
            e.printStackTrace();
        }
    }

    private static void retrieveCourses(String authorId) {
//        Scanner input = new Scanner(System.in);
//        String newAuthor = input.next();
        System.out.println("Retrieving courses for author " + authorId);
    }

}