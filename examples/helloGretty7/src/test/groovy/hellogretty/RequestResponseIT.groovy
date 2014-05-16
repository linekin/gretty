package hellogretty

import geb.spock.GebReportingSpec

class RequestResponseIT extends GebReportingSpec {

  def 'should get expected static page'() {
  when:
    go 'http://localhost:8080/helloGretty7/index.html'
  then:
    $('h1').text() == 'Hello, world!'
    $('p', 0).text() == /This is static HTML page./
  }

  def 'should get expected response from servlet'() {
  when:
    go 'http://localhost:8080/helloGretty7/dynamic'
  then:
    $('h1').text() == 'Hello, world!'
    $('p', 0).text() == /This is dynamic HTML page generated by servlet./
  }
}
