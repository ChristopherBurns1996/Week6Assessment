pipeline{
        agent any
        stages{
		stage('---clearprev---'){
                        steps{
                                sh "sudo rm -r /var/www/html/*"
                        }
                }
		stage('---pushhtml---'){
                        steps{
                                sh "sudo cp -rpf /var/lib/jenkins/workspace/s-Team/* /var/www/html"
				sh "sudo docker-compose down"
				sh "sudo docker build -t='christophperrinsexample:latest' ."
				sh "sudo docker-compose up -d"
                        }
                }
	}
}