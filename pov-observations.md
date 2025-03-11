
# POV Observations

## Running dcover create --preflight for the first time

No issues - the warnings found were I was missing cover-annotations and also E199 for the following libraries (all modules had at least one of the three in various combinations):

```text
- Jakarta RESTful WS API 2.0.1
- Jersey 2.25.1
- PowerMock 1.6.1
```

## Running dcover fix-build

The following error occurred on every single module (only the 1st module is shown). Despite this error it did still manage to apply cover-annotations successfully. This problem went away once I disabled/overrode this particular check that was bring brought in by the project's external parent.

```java
dcover fix-build
INFO  Diffblue Cover 2025.03.01-721681d-licensed
INFO
INFO  Command: refactor
INFO  Apply refactorings.
INFO
INFO  Discovered modules:
INFO  - org.symphonyoss.symphony.integrations:integration-commons
INFO  - org.symphonyoss.symphony.integrations:integration-metrics
INFO  - org.symphonyoss.symphony.integrations:integration-webhook
INFO  - org.symphonyoss.symphony.integrations:integration-api-client
INFO  - org.symphonyoss.symphony.integrations:integration-authorization
INFO  - org.symphonyoss.symphony.integrations:integration-authentication-api
INFO
INFO
INFO  [1/6] Refactoring module: org.symphonyoss.symphony.integrations:integration-commons
INFO  ===================================================================================
INFO
INFO  Detected Java version 1.8.0_432
INFO  Selected build system: Maven
INFO  Selected classpath from build system maven
INFO  Selected Java language compliance level: 1.8, because 1.7 is not supported
INFO  Applying refactorings from configuration file /Users/john/symphonyoss-App-Integrations-Commons/integration-commons/.diffblue/refactorings.yml
INFO  Refreshing project state
INFO  Validating refactorings -- this may take a few moments...
WARN  Refactorings failed. Restoring changes.
ERROR E012: Error when using build system
      An error occurred when using the build system.
      Read the output of your build system below to fix the problem.
      Build command: /Users/john/.sdkman/candidates/maven/current/bin/mvn -Dmaven.ext.class.path=/opt/diffblue/cover-cli/cover-buildsystem-maven-spy-jar-with-dependencies.jar -Dcom.diffblue.cover.skipTests=true --batch-mode --projects=org.symphonyoss.symphony.integrations:integration-commons --global-settings=/Users/john/.sdkman/candidates/maven/current/conf/settings.xml install -Dmaven.compiler.failOnWarning=false --also-make -DskipTests -DskipITs --threads=1C
      Standard output:
      [INFO] Scanning for projects...
      [INFO]
      [INFO] Using the MultiThreadedBuilder implementation with a thread count of 12
      [INFO]
      [INFO] -----< org.symphonyoss.symphony.integrations:integration-commons >------
      [INFO] Building integration-commons 1.9.0-SNAPSHOT
      [INFO]   from pom.xml
      [INFO] --------------------------------[ jar]---------------------------------
      [INFO] Downloading from oss-sonatype: https://oss.sonatype.org/content/repositories/snapshots/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.pom
      [INFO] Downloading from central: https://repo.maven.apache.org/maven2/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.pom
      [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.pom (8.5 kB at 120 kB/s)
      [INFO] Downloading from oss-sonatype: https://oss.sonatype.org/content/repositories/snapshots/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.jar
      [INFO] Downloading from central: https://repo.maven.apache.org/maven2/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.jar
      [INFO] Downloaded from central: https://repo.maven.apache.org/maven2/com/diffblue/cover/cover-annotations/1.3.0/cover-annotations-1.3.0.jar (19 kB at 1.1 MB/s)
      [INFO]
      [INFO] --- build-helper:1.12:regex-properties (replace-property) @ integration-commons ---
      [INFO]
      [INFO] --- build-helper:1.12:parse-version (parse-version) @ integration-commons ---
      [INFO]
      [INFO] --- buildnumber:1.4:create (generate-revision) @ integration-commons ---
      [INFO] ShortRevision tag detected. The value is '50'.
      [INFO] Executing: /bin/sh -c cd '/Users/john/symphonyoss-App-Integrations-Commons/integration-commons' && 'git' 'rev-parse' '--verify' '--short=50' 'HEAD'
      [INFO] Working directory: /Users/john/symphonyoss-App-Integrations-Commons/integration-commons
      [INFO] Storing buildNumber: f177e03504757057be895be5b9b67236b007b463 at timestamp: 1741694805540
      [INFO] Storing buildScmBranch: dev
      [INFO]
      [INFO] --- buildnumber:1.4:create (generate-buildnumber) @ integration-commons ---
      [INFO] Storing buildNumber: f177e03504757057be895be5b9b67236b007b463 at timestamp: 1741694805569
      [INFO] Storing buildScmBranch: dev
      [INFO]
      [INFO] --- remote-resources:1.5:process (process-resource-bundles) @ integration-commons ---
      [INFO]
      [INFO] --- resources:2.7:resources (default-resources) @ integration-commons ---
      [INFO] Using 'UTF-8' encoding to copy filtered resources.
      [INFO] Copying 2 resources
      [INFO] Copying 3 resources
      [INFO]
      [INFO] --- compiler:3.6.0:compile (default-compile) @ integration-commons ---
      [INFO] Nothing to compile - all classes are up to date
      [INFO]
      [INFO] --- resources:2.7:testResources (default-testResources) @ integration-commons ---
      [INFO] Using 'UTF-8' encoding to copy filtered resources.
      [INFO] Copying 8 resources
      [INFO] Copying 3 resources
      [INFO]
      [INFO] --- compiler:3.6.0:testCompile (default-testCompile) @ integration-commons ---
      [INFO] Nothing to compile - all classes are up to date
      [INFO]
      [INFO] --- surefire:2.19.1:test (default-test) @ integration-commons ---
      -------------------------------------------------------
      T E S T S
      ---------
      <snip>
      Results :
      Tests run: 215, Failures: 0, Errors: 0, Skipped: 0
      [INFO]
      [INFO] --- jar:3.0.2:jar (default-jar) @ integration-commons ---
      [INFO] Building jar: /Users/john/symphonyoss-App-Integrations-Commons/integration-commons/target/integration-commons-1.9.0-SNAPSHOT.jar
      [INFO]
      [INFO] --- jar:3.0.2:test-jar (default) @ integration-commons ---
      [INFO] Building jar: /Users/john/symphonyoss-App-Integrations-Commons/integration-commons/target/integration-commons-1.9.0-SNAPSHOT-tests.jar
      [INFO]
      [INFO] --- enforcer:1.4.1:enforce (default) @ integration-commons ---
      [WARNING] Rule 3: org.symphonyoss.maven.enforcer.RequirePomMetadataRule failed with message:
      RequirePomMetadataRule is failing with the following error: pom.xml is missing <description> element  or it's empty
      [INFO] ------------------------------------------------------------------------
      [INFO] BUILD FAILURE
      [INFO] ------------------------------------------------------------------------
      [INFO] Total time:  3.993 s (Wall Clock)
      [INFO] Finished at: 2025-03-11T12:06:48Z
      [INFO] ------------------------------------------------------------------------
      [ERROR] Failed to execute goal org.apache.maven.plugins:maven-enforcer-plugin:1.4.1:enforce (default) on project integration-commons: Some Enforcer rules have failed. Look above for specific messages explaining why the rule failed. -> [Help 1]
      [ERROR]
      [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
      [ERROR] Re-run Maven using the -X switch to enable full debug logging.
      [ERROR]
      [ERROR] For more information about the errors and possible solutions, please read the following articles:
      [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
      Exit code: 1
      If you want to customize your build system configuration for Diffblue Cover
      follow the guidelines here:
      https://docs.diffblue.com/features/cover-cli/project-configuration/configuring-cover-to-work-with-your-projects-build-system/
INFO
INFO  [2/6] Refactoring module: org.symphonyoss.symphony.integrations:integration-metrics
INFO  ===================================================================================
```

## Coverage reports
