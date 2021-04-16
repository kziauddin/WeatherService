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
	pwsh(script: '
		cd weather
		mvn package')
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
               cd ..
            """)
         }
      }
   }
}
