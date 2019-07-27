

node{
     stage ('checkout'){
	 git 'https://github.com/YSAM-GITHUB/BUNU_JAVA'

	  }
	  stage('Build'){
			////Get maven home path and build
			def mvnHome = tool name: 'Maven 3.5.4', type:'maven'
			sh "${mvnHome}/bin/mvn package"
	   }
	   stage('Test'){
			def mvnHome = tool name: 'Maven 3.5.4', type:'maven'
			sh "${mvnHome}/bin/mvn  test"
      }
    }
