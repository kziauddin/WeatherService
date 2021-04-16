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
      stage('GitHub Jenkins Ant Build') 
      {
        steps 
        {
          //git 'https://github.com/learn-devops-fast/rps-ant.git'
          //sh 'ant clean compile test package war'
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
               cd ..
            """)
         }
      }
   }
}
