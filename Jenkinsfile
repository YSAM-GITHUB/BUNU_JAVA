

node{
     stage('git checkout'){
	git credentialsId: 'jenkin-creds', url: 'https://github.com/YSAM-GITHUB/BUNU_JAVA'
	   }
      stage('Maven Package'){
			def mvnHome = tool name: 'Maven-3.6.1', type: 'maven'
                        def mvnCMD = "${mvnHome}/bin/mvn"
			sh "${mvnCMD} clean package"
	     }
     }
