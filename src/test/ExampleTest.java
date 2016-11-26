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
    Vertex v_Dead = new Vertex().setName("v_Dead");
 
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
    Edge e_died1 = new Edge()
            .setName("e_died1")
            .setSourceVertex(v_Single)
            .setTargetVertex(v_Dead);
    Edge e_died2 = new Edge()
            .setName("e_died2")
            .setSourceVertex(v_Married)
            .setTargetVertex(v_Dead);
    Edge e_died3 = new Edge()
            .setName("e_died3")
            .setSourceVertex(v_Divorced)
            .setTargetVertex(v_Dead);
    Edge e_died4 = new Edge()
            .setName("e_died4")
            .setSourceVertex(v_Widowed)
            .setTargetVertex(v_Dead);
    Edge e_restart = new Edge()
            .setName("e_restart")
            .setSourceVertex(v_Dead)
            .setTargetVertex(v_Start);
 
    // Add vertexes to the model
    model.addVertex(v_Start);
    model.addVertex(v_Single);
    model.addVertex(v_Married);
    model.addVertex(v_Widowed);
    model.addVertex(v_Divorced);
    model.addVertex(v_Dead);


 
    // Add edges to the model
    model.addEdge(e_Born);
    model.addEdge(e_getMarried);
    model.addEdge(e_getMarried1);
    model.addEdge(e_getMarried2);
    model.addEdge(e_getDivorced);
    model.addEdge(e_getSpouseDeceased);
    model.addEdge(e_died1);
    model.addEdge(e_died2);
    model.addEdge(e_died3);
    model.addEdge(e_died4);
    model.addEdge(e_restart);
 
    return model;
}
	Person jane= null;
	
	public void e_Born() {
		jane=new Person("Jane",
				IsoChronology.INSTANCE.date(1990, 7, 15),
				Person.Sex.FEMALE, new statusSingle(), "jane@example.com");  
	}
	public void e_getMarried() throws CivilException {
		jane.getMarried();
	}
	public void e_getMarried1() throws CivilException {
		jane.getMarried();
	}
	public void e_getMarried2() throws CivilException {
		jane.getMarried();
	}
	public void e_getDivorced() throws CivilException {
		jane.getDivorced();
	}
	public void e_getSpouseDeceased() throws CivilException {
		jane.getSpouseDeceased();
	}
	
	public void e_died1() throws Exception {
		jane.die();
	}
	public void e_died2() throws Exception {
		jane.die();
	}
	public void e_died3() throws Exception {
		jane.die();
	}
	public void e_died4() throws Exception {
		jane.die();
	}
	
	public void e_restart() throws Exception {
		jane= null;
	}
	
	public void v_Start() {
	    Assert.assertNull(jane);
	}
	
	public void v_Single() {
	    Assert.assertTrue(jane.isSingle());
	}
	public void v_Married() {
	    Assert.assertTrue(jane.isMarried());
	}
	public void v_Divorced() {
	    Assert.assertTrue(jane.isDivorced());
	}
	public void v_Widowed() {
	    Assert.assertTrue(jane.isWidowed());
	}
	public void v_Dead() {
	    Assert.assertTrue(jane.isDead());
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
	    this.setPathGenerator(new QuickRandomPath(new VertexCoverage(100)));
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
	@Test
	public void EdgeCoverageTest() {
	    // Build the model (make it immutable) and give it to the execution context
	    this.setModel(model.build());
	    // Tell GraphWalker to run the model in a random fashion,
	    // until every vertex is visited at least once.
	    // This is called the stop condition.
		System.out.println("QuickRandomPath with edge coverage:");
	    this.setPathGenerator(new QuickRandomPath(new EdgeCoverage(100)));
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
