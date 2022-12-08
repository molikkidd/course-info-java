package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrieverService;
import com.pluralsight.courseinfo.cli.service.PluralSightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CourseRetriever {
//    add logger
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args) {
        LOG.info("Course Retriever starting");

        if(args.length == 0 ) {
            LOG.warn("Please provide an author name as first argument.");
            return;
        }

        try {
            retrieveCourses(args[0]);
//            PluralSightCourse course = new PluralSightCourse("mzk","swe","99:59:57", "https://someplace.com",false);
//            LOG.info("course: {}", course);
        } catch(Exception e) {

            LOG.error("Unexpected error", e);
        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();

        List<PluralSightCourse> coursesToStore = courseRetrieverService.getCoursesFor(authorId);
        LOG.info("Retrieved the following courses {}", coursesToStore);
    }

}