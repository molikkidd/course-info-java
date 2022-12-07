package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrieverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CourseRetriever {
//    add logger
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args) {
        LOG.info("Course Retriever starting");

        if(args.length == 0 ) {
            LOG.warn("Please provide an author name as first arguement.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch(Exception e) {
            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
//        Scanner input = new Scanner(System.in);
//        String newAuthor = input.next();
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();
        String coursesToStore = courseRetrieverService.getCoursesFor(authorId);
        LOG.info("Retrieved the following courses {}", coursesToStore);
    }

}