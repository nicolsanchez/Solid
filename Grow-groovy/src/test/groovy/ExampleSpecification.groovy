import spock.lang.Specification

class ExampleSpecification extends Specification{
    def "Should be a simple assertion"(){
        expect:
        1 == 1
    }

    def "Should be a simple assertion 2"(){
        expect:
        2 == 2
    }
}
