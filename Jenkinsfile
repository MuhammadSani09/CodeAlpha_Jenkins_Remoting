def buildOn = { nodeName, architecture ->
    node(nodeName) {
        stage("Build and test ${architecture}") {
            echo "Building on ${env.NODE_NAME}"

            writeFile file: 'Hello.java', text: '''
public class Hello {
    public static void main(String[] args) {
        if (2 + 3 != 5) {
            throw new AssertionError("Calculation failed");
        }
        System.out.println("Java test passed!");
    }
}
'''

            withEnv(["EXPECTED_ARCH=${architecture}"]) {
                sh '''
                    set -eu
                    test "$(uname -m)" = "$EXPECTED_ARCH"
                    test "$(whoami)" = "jenkins"

                    mkdir -p classes
                    javac -d classes Hello.java
                    jar --create --file "hello-$EXPECTED_ARCH.jar" \\
                        --main-class Hello -C classes .

                    {
                        echo "Node: $NODE_NAME"
                        hostname
                        uname -m
                        whoami
                        date -u
                        java -jar "hello-$EXPECTED_ARCH.jar"
                    } > "report-$EXPECTED_ARCH.txt"

                    cat "report-$EXPECTED_ARCH.txt"
                '''
            }

            archiveArtifacts(
                artifacts: "hello-${architecture}.jar,report-${architecture}.txt",
                fingerprint: true
            )
        }
    }
}

timeout(time: 5, unit: 'MINUTES') {
    parallel(
        'Mac ARM64': {
            buildOn('agent-arm64', 'aarch64')
        },
        'Azure AMD64': {
            buildOn('agent-cloud-amd64-v2', 'x86_64')
        }
    )
}
