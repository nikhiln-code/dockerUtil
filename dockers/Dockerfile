# syntax=docker/dockerfile:1
# Pull the minimal Ubuntu image
FROM ubuntu

# Install Nginx
RUN apt-get -y update && apt-get -y install nginx


# Install Curl
RUN apt-get -y update; apt-get -y install curl

# Copy the Nginx config
#COPY default /etc/nginx/jdoodle/default

# Expose the port for access
EXPOSE 80/tcp

# Run the Nginx server
CMD ["/usr/sbin/nginx", "-g", "daemon off;"]