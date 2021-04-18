pipeline 
{
   agent any

   stages 
   {
      stage('Verify Branch') 
      {
         steps 
         {
            echo "$GIT_BRANCH"
         }
      }
      stage('Maven Build')
      {
	steps
	{
	  pwsh(script: """
	       cd weather
	       mvn package
            """)
	}
      }
      stage('Docker Build') 
      {
         steps 
         {
            pwsh(script: 'docker images -a')
            pwsh(script: """
	       cd weather
               docker build -t jenkins-pipeline .
	       docker stop  myweather
	       docker rm myweather
               docker images -a
	       docker container run --name myweather -p 8083:8080 -d jenkins-pipeline
               cd ..
            """)
         }
      }
      stage('Dynamic Project Deploy')
      {
	steps
	  {
	    pwsh(script: """
	       cd Testweather
	       docker build -t mywebapp
	       docker images -a 
	       docker container run --name mywebappl -p 8080:8080 -d mywebapp
              """)
		
	  }
      }
   }
}
