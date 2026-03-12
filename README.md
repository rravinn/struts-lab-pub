# 🚀 Struts Lab
> A broken, vulnerable struts2 app

[![Java Version](https://img.shields.io/badge/Java%2011-orange?style=for-the-badge&logo=openjdk)]
[![Struts Version](https://img.shields.io/badge/Struts%202-grey?style=for-the-badge&logo=struts)]

---

## 🧐 Overview
This projects purpose is to establish intentionally vulnerable environments for testing. It utilizes Java on Struts. At this time, the application is built for testing struts upload on version 2.5.3.

### Key Features
- **Feature A**: Struts File Upload.
- **Feature B**: Log4j Implementation.
- **MVC Architecture**: Fully decoupled logic using Struts 2/6 patterns(it doesn't, but saving this for later).

## 🛠 Tech Stack
- **Backend**: Java 11, Apache Struts 2
- **Build Tool**: Maven 
- **Frontend**: JSP
- **Server**: Tomcat
- **Database**: None at this time

## 🚀 Getting Started

### Prerequisites
- JDK 11 or higher
- Maven 3.x

### Installation & Run
1. **Clone the repo**
   ```bash
   git clone https://github.com/rravinn/struts-lab
   cd your-repo-name
2. mvn clean install
3. docker build -t struts-lab .
4. docker run -d -p <host-port>:<container-port> --name <container-name> struts-lab
    - change <host-port>:<container-port> as needed, if dont know what to do here, just put 8080:8080
    - change <container-name> to whatever you want to call the container, this is to help you not have to type out the container ID that is autoassigned by Docker
5. In a web browser navigate to localhost:<host-port>
6. Considerations:
    - Firefox browser: To proxy localhost traffic through burpsuite or another proxy application, navigate to about:config and accept risk. Change the network.proxy.allow_hijacking_localhost setting to true