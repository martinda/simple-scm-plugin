package jenkins.plugins.simplescm;

import hudson.scm.ChangeLogParser;

class SimpleSCMChangeLogParser extends ChangeLogParser {
    SimpleSCMChangeLogParser() {
        System.out.println("SimpleSCMChageLogParser()");
    }
}
