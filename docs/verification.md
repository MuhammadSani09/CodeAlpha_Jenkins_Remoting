# Verified build evidence

Source: Jenkins screenshots and console output supplied by Muhammad Sani on October 7, 2026. The excerpts below are selected from that output, not a new build or a reconstructed full console log.

## Preliminary cloud test

Job: `cloud-agent-test`, build #2. Screenshot-reported duration: 34 seconds.

```text
Running on agent-cloud-amd64-v2 in /home/jenkins/agent/workspace/cloud-agent-test
Running on: agent-cloud-amd64-v2
jenkins-agent-cloud
x86_64
jenkins
Cloud agent test passed!
Finished: SUCCESS
```

## Final distributed build

Job: `distributed-java-build`, build #1. Both parallel branches selected their intended nodes:

```text
[Pipeline] parallel
[Pipeline] { (Branch: Mac ARM64)
[Pipeline] { (Branch: Azure AMD64)
Running on agent-arm64 in /home/jenkins/agent/workspace/distributed-java-build
Running on agent-cloud-amd64-v2 in /home/jenkins/agent/workspace/distributed-java-build
```

ARM64 execution report printed in the console:

```text
Node: agent-arm64
8c5fbb821401
aarch64
jenkins
Wed Oct  7 17:58:37 UTC 2026
Java test passed!
```

Azure AMD64 execution report printed in the console:

```text
Node: agent-cloud-amd64-v2
jenkins-agent-cloud
x86_64
jenkins
Wed Oct  7 17:58:38 UTC 2026
Java test passed!
```

The console showed `javac`, JAR creation, execution of each JAR, artifact archiving and fingerprinting, followed by:

```text
[Pipeline] End of Pipeline
Finished: SUCCESS
```

The build-page screenshot listed:

| Artifact | Screenshot-reported size |
| --- | --- |
| `hello-aarch64.jar` | 747 B |
| `hello-x86_64.jar` | 737 B |
| `report-aarch64.txt` | 94 B |
| `report-x86_64.txt` | 109 B |

Parallel branch allocation and successful work on both machines are verified. These records do not establish a speedup over sequential execution. The differing JAR sizes do not make them native architecture-specific binaries.
