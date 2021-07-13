# SSL
Mutual TLS Certificate Verification
In practice, when we try integrating with much more secured endpoints like the ones that have been secured using one-way or 2-way mutual authentication, we will get into the real challenge as we need to make a lot of secured handshakes before we can get hold of the actual data.
# Keystores and Truststores are required for SSL communication and verification.
A Keystore is used to store the server's private key and own identity certificate. Keystores are used by the server for communications
Truststore is used for storage of certificates from the trusted Certificate Authority(CA). Truststores are used to verify the server certificates before communication, to allow handshakes.
# keystore and trustore can be created using openssl with a simple Bash script
At the end of this script, you can see a keystore.p12 and trustore.jks. The .p12 file denotes PKCS12 format whereas .jks file denotes JKS(Java KeyStore) format.

# application.properties

application.protocol=TLSv1.2

application.keystore.path=/path/to/keystore.p12

application.keystore.type=PKCS12

application.keystore.password=passPhrase

application.truststore.path=/path/to/truststore.jks

application.truststore.type=JKS

application.truststore.password=passPhrase

# We'll need to add another library, HttpClient, to our project to provide SSL configurations

<dependency>
	<groupId>org.apache.httpcomponents</groupId>
	<artifactId>httpclient</artifactId>
</dependency>

# We'll be creating a Keystore and Truststore instance each, and add them to the SSLConnectionSocketFactory for verification.
  Load Keystore
  
 Load Truststore
 
 Build SSLConnectionSocket to verify certificates in truststore
 

Additionally, we'll use a HostnameVerifier so that the factory can check/match the Common Name defined in the certificate with the SSL Session made with the actual domain

Refer to https://github.com/arpendu11/spring-boot-rest-template/tree/master/src/main/java/com/stackabuse/config
