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
                                sh "sudo cp -r /var/lib/jenkins/workspace/Week6Assessment/* /var/www/html"
                        }
                }
	}
}