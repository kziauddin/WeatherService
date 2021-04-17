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
               docker images -a
               docker build -t jenkins-pipeline .
               docker images -a
	       docker container run --name jenkins-pipeline -p 8080:8080 -d myweather
               cd ..
            """)
         }
      }
   }
}
