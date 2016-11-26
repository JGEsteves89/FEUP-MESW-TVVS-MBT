package test;

import java.time.chrono.IsoChronology;
import java.util.concurrent.TimeUnit;

import org.graphwalker.core.condition.CombinedCondition;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.VertexCoverage;
import org.graphwalker.core.condition.ReachedEdge;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.PathGenerator;
import org.graphwalker.core.generator.QuickRandomPath;
import org.graphwalker.core.generator.ShortestAllPaths;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.machine.SimpleMachine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.junit.Assert;
import org.junit.Test;

import status.CivilException;
import status.Person;
import status.statusDivorced;
import status.statusSingle;
import status.statusWidowed;

@org.graphwalker.java.annotation.Model(file = "com/company/SmallTest.graphml")
public class ExampleTest extends ExecutionContext {
	public Model createModel() {
 
    // Create a new, empty model
    Model model = new Model();
 
    // Create vertexes (nodes)
    Vertex v_Start = new Vertex().setName("v_Start");
    Vertex v_Single = new Vertex().setName("v_Single");
    Vertex v_Married = new Vertex().setName("v_Married");
    Vertex v_Widowed = new Vertex().setName("v_Widowed");
    Vertex v_Divorced = new Vertex().setName("v_Divorced");
 
    // Create edges
    Edge e_Born = new Edge()
	        .setName("e_Born")
	        .setSourceVertex(v_Start)
	        .setTargetVertex(v_Single);
    Edge e_getMarried = new Edge()
            .setName("e_getMarried")
            .setSourceVertex(v_Single)
            .setTargetVertex(v_Married);
    Edge e_getMarried1 = new Edge()
            .setName("e_getMarried")
            .setSourceVertex(v_Widowed)
            .setTargetVertex(v_Married);
    Edge e_getMarried2 = new Edge()
            .setName("e_getMarried")
            .setSourceVertex(v_Divorced)
            .setTargetVertex(v_Married);
    Edge e_getDivorced = new Edge()
            .setName("e_getDivorced")
            .setSourceVertex(v_Married)
            .setTargetVertex(v_Divorced);
    Edge e_getSpouseDeceased = new Edge()
            .setName("e_getSpouseDeceased")
            .setSourceVertex(v_Married)
            .setTargetVertex(v_Widowed);
    Edge e_Error_SingletoDivorced = new Edge()
            .setName("e_Error_SingletoDivorced")
            .setSourceVertex(v_Single)
            .setTargetVertex(v_Divorced);
    Edge e_Error_SingletoWidowed = new Edge()
            .setName("e_Error_SingletoWidowed")
            .setSourceVertex(v_Single)
            .setTargetVertex(v_Widowed);
    Edge e_Error_DivorcedtoWidowed = new Edge()
            .setName("e_Error_DivorcedtoWidowed")
            .setSourceVertex(v_Divorced)
            .setTargetVertex(v_Widowed);
    Edge e_Error_WidowedtoDivorced = new Edge()
            .setName("e_Error_WidowedtoDivorced")
            .setSourceVertex(v_Widowed)
            .setTargetVertex(v_Divorced);
 
    // Add vertexes to the model
    model.addVertex(v_Start);
    model.addVertex(v_Single);
    model.addVertex(v_Married);
    model.addVertex(v_Widowed);
    model.addVertex(v_Divorced);

 
    // Add edges to the model
    model.addEdge(e_Born);
    model.addEdge(e_getMarried);
    model.addEdge(e_getMarried1);
    model.addEdge(e_getMarried2);
    model.addEdge(e_getDivorced);
    model.addEdge(e_getSpouseDeceased);
    model.addEdge(e_Error_SingletoDivorced);
    model.addEdge(e_Error_SingletoWidowed);
    model.addEdge(e_Error_DivorcedtoWidowed);
    model.addEdge(e_Error_WidowedtoDivorced);
 
    return model;
}
	Person jane;
	
	public void e_Born() {
		jane=new Person("Jane",
				IsoChronology.INSTANCE.date(1990, 7, 15),
				Person.Sex.FEMALE, new statusSingle(), "jane@example.com");  
	}
	public void e_getMarried() throws CivilException {
		Person.getMarried(jane);
	}
	public void e_getMarried1() throws CivilException {
		Person.getMarried(jane);
	}
	public void e_getMarried2() throws CivilException {
		Person.getMarried(jane);
	}
	public void e_getDivorced() throws CivilException {
		Person.getDivorced(jane);
	}
	public void e_getSpouseDeceased() throws CivilException {
		Person.getSpouseDeceased(jane);
	}
	public void e_Error_SingletoDivorced() {
	    try {
			Person.getDivorced(jane);
	    } catch (CivilException e) {
	    	System.out.println(e.getMessage());
	    	Assert.assertEquals(e.getMessage(),"A single person cannot get divorced");
	    	jane.setStatus(new statusDivorced());
	    }
	}
	public void e_Error_SingletoWidowed() {
	    try {
			Person.getSpouseDeceased(jane);
	    } catch (CivilException e) {
	    	System.out.println(e.getMessage());
	    	Assert.assertEquals(e.getMessage(),"A single person cannot get widowed");
	    	jane.setStatus(new statusWidowed());
	    }
	}
	public void e_Error_DivorcedtoWidowed() {
	    try {
			Person.getSpouseDeceased(jane);
	    } catch (CivilException e) {
	    	System.out.println(e.getMessage());
	    	Assert.assertEquals(e.getMessage(),"A divorced person cannot get widowed");
	    	jane.setStatus(new statusWidowed());
	    }
	}
	public void e_Error_WidowedtoDivorced() {
	    try {
			Person.getDivorced(jane);
	    } catch (CivilException e) {
	    	System.out.println(e.getMessage());
	    	Assert.assertEquals(e.getMessage(),"A widowed person cannot get divorced");
	    	jane.setStatus(new statusDivorced());
	    }
	}

	public void v_Start() {
	    Assert.assertNull(jane);
	}
	public void v_Single() {
	    Assert.assertEquals(jane.getStatusString(),"single");
	}
	public void v_Married() {
	    Assert.assertEquals(jane.getStatusString(),"married");
	}
	public void v_Divorced() {
	    Assert.assertEquals(jane.getStatusString(),"divorced");
	}
	public void v_Widowed() {
	    Assert.assertEquals(jane.getStatusString(),"widowed");
	}
	
	Model model = createModel();
	
	@Test
	public void VertexCoverageTest() {
	    // Build the model (make it immutable) and give it to the execution context
	    this.setModel(model.build());
	    
	    // Tell GraphWalker to run the model in a random fashion,
	    // until every vertex is visited at least once.
	    // This is called the stop condition.
		System.out.println("QuickRandomPath with vertex coverage:");
		CombinedCondition condition = new CombinedCondition();
		condition.addStopCondition(new VertexCoverage(100));
		condition.addStopCondition(new org.graphwalker.core.condition.TimeDuration(10,TimeUnit.SECONDS));
	    runPath( new QuickRandomPath(condition),model);
	}
	@Test
	public void Error_SingletoDivorcedTest() {
	    this.setModel(model.build());
		System.out.println("QuickRandomPath with ReachedEdge e_Error_SingletoDivorced:");
	    runPath(new AStarPath(new ReachedEdge("e_Error_SingletoDivorced")),model);
	}
	@Test
	public void Error_SingletoWidowedTest() {
	    this.setModel(model.build());
		System.out.println("QuickRandomPath with ReachedEdge e_Error_SingletoWidowed:");
	    runPath(new AStarPath(new ReachedEdge("e_Error_SingletoWidowed")),model);
	}
	@Test
	public void Eror_DivorcedtoWidowedTest() {
	    this.setModel(model.build());
		System.out.println("QuickRandomPath with ReachedEdge e_Error_DivorcedtoWidowed:");
	    runPath(new AStarPath(new ReachedEdge("e_Error_DivorcedtoWidowed")),model);
	}
	@Test
	public void Error_WidowedtoDivorcedTest() {
	    this.setModel(model.build());
		System.out.println("QuickRandomPath with ReachedEdge e_:");
	    runPath(new AStarPath(new ReachedEdge("e_Error_WidowedtoDivorced")),model);
	}
	public void runPath(PathGenerator p, Model model){
	    this.setPathGenerator(p);
	    // Get the starting vertex (v_Start)
	    setNextElement(model.getVertices().get(0));
	    //Create the machine that will control the execution
	    Machine machine = new SimpleMachine(this);
	    // As long as the stop condition of the path generator is not fulfilled, hasNext will return true.
	    while (machine.hasNextStep()) {
	        //Execute the next step of the model.
	        machine.getNextStep();
	    }
	}

}
