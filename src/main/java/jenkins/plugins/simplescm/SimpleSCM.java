package jenkins.plugins.simplescm;

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Descriptor;
import hudson.model.Descriptor.FormException;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.scm.ChangeLogParser;
import hudson.scm.SCM;
import hudson.scm.SCMDescriptor;
import hudson.scm.SCMRevisionState;

import java.io.File;
import java.io.IOException;
import java.lang.InterruptedException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

public class SimpleSCM extends SCM {

    String repositoryUrl;

    @DataBoundConstructor
    public SimpleSCM(
        String repositoryUrl
    )
    {
        this.repositoryUrl = repositoryUrl;
    }

    @Override
    public void checkout(
        Run<?,?> build,
        Launcher launcher,
        FilePath workspace,
        TaskListener listener,
        File changelogFile,
        SCMRevisionState baseline
    ) throws IOException, InterruptedException
    {
      System.out.println("checkout()");
    }

    @Override
    public ChangeLogParser createChangeLogParser() {
      System.out.println("createChangeLogParser()");
      return new SimpleSCMChangeLogParser();
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }

    @Extension
    public static final class DescriptorImpl extends SCMDescriptor<SimpleSCM> {
        public DescriptorImpl() {
          super(SimpleSCM.class, null);
          load();
        }

        @Override
        public SCM newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            SimpleSCM scm = (SimpleSCM) super.newInstance(req, formData);
            return scm;
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            save();
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Simple SCM";
        }
    
    }
}
