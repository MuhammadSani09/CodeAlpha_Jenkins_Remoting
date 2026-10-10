# Evidence and submission checklist

## Repository preparation

- [x] README documenting the actual two-machine architecture and limitations.
- [x] Jenkinsfile matching the successful distributed demonstration.
- [x] Java source included separately for readability.
- [x] Verification summary derived from supplied console output and screenshots.
- [x] Ignore rules for private keys, secret files, and generated binaries.
- [ ] Add original screenshots to `evidence/`.
- [ ] Add original downloaded text reports to `evidence/`.
- [ ] Save the complete successful console output as `evidence/distributed-build-console.txt`.
- [ ] Review every upload for passwords, node secrets, private keys, tokens, personal information, and unnecessary account identifiers.
- [ ] Create the public GitHub repository `CodeAlpha_Jenkins_Remoting` and upload this folder's contents.

## Recommended evidence filenames

| Filename | Evidence to include |
| --- | --- |
| `distributed-build-success.png` | Successful build #1 and all four archived artifacts |
| `nodes-online.png` | Local ARM64 and Azure AMD64 agent status |
| `cloud-agent-test-success.png` | Successful preliminary cloud-agent test #2 |
| `report-aarch64.txt` | Original downloaded ARM64 report |
| `report-x86_64.txt` | Original downloaded Azure AMD64 report |
| `distributed-build-console.txt` | Complete successful distributed-build log |

JARs remain available as Jenkins build artifacts; they are ignored by this source repository. Screenshot evidence and the text reports are sufficient to document them without committing generated binaries.

## Walkthrough video

- [ ] Explain the controller and the two agents.
- [ ] Identify the ARM64 Docker agent on the Mac and the native AMD64 Azure VM.
- [ ] Explain that WebSocket traffic reaches the local controller through the SSH tunnel.
- [ ] Show the Jenkinsfile's parallel branches and explicit node selection.
- [ ] Show build #1's success, both execution reports, and archived artifacts.
- [ ] Explain that jobs run as `jenkins`, not root.
- [ ] State that the local emulated AMD64 agent was only an earlier experiment.
- [ ] Hide credentials, private keys, and secrets throughout the recording.

## Submission

- [ ] Publish/share the walkthrough according to the internship batch instructions.
- [ ] Include the public GitHub repository link where required.
- [ ] Submit through the actual batch-provided submission form.

Do not mark the video, GitHub publication, or final form complete until each has actually been done.
