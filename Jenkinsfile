

node{
     stage ('git checkout'){
	 git 'https://github.com/YSAM-GITHUB/BUNU_JAVA.git'

	   }

	stage('unit Test'){
			def mvnHome = tool name: 'Maven-3.6.1', type: 'maven'
                        def mvnCMD  = "${mvnHome}/bin/mvn"
			sh "${mvnCMD} test"
	  
           }
        stage('Maven Package){
			def mvnHome = tool name: 'Maven-3.6.1', type: 'maven'
                        def mvnCMD  = "${mvnHome}/bin/mvn"
			sh "${mvnCMD} clean package"
	   }
	   

     }
