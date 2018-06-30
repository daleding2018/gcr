#! groovy
pipeline {
	agent any

	environment {
            RNS="iot_docker"
            MODULE="auth"
	    SCRIPT_PATH="/usr/local/MavenRepository/iot"
	}

	stages {
	    stage('编译') {
	         steps {
	             echo "start compile"
	             sh "${SCRIPT_PATH}/compile.sh"
	         }
	    } 

	    stage('构建镜像') {
	         steps {
	             echo "start build image"
	             sh "${SCRIPT_PATH}/build-images.sh ${RNS} ${MODULE}"
	         }
	    }

	    stage('发布系统') {
	         steps {
	             echo "start deploy service"
	             sh "${SCRIPT_PATH}/deploy.sh"
	         }
	    }
	}
}
