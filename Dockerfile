FROM jenkins/jenkins:lts

USER root
####### INSTALL DOCKER CLI
RUN set -eux; \
  apt-get update; \
  apt-get install -y --no-install-recommends \
    gnupg2 \
    software-properties-common; \
  curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -; \
  add-apt-repository \
     "deb [arch=amd64] https://download.docker.com/linux/debian \
     $(lsb_release -cs) \
     stable"; \
  apt-get update; \
  apt-get install -y --no-install-recommends \
    docker-ce-cli \
    containerd.io; \
  rm -rf /var/lib/apt/lists/*
USER jenkins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli  --plugin-file /usr/share/jenkins/ref/plugins.txt
