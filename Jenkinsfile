def branch = this.getProperty('binding').getVariable('GIT_BRANCH')

def create_job(String _remote='MindTouch', String _branch) {
  pipelineJob('petetest_pipeline_' + _branch) {
    definition {
      cps {
        script(readFileFromWorkspace('deploy.groovy'))
        sandbox()
      }
    }
  }
}
