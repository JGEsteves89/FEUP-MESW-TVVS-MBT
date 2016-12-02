
import java.time.chrono.IsoChronology;

import org.graphwalker.core.condition.*;
import org.graphwalker.core.generator.*;
import org.graphwalker.core.machine.*;
import org.graphwalker.core.model.*;
import org.junit.*;

import status.*;


public class GraphWalkerTestIntro extends ExecutionContext  {

		public void e_Born() {}
		public void e_getMarried() throws CivilException {}
		public void e_getDivorced() throws CivilException {}

		public void v_Start() {}
		public void v_Single() {}
		public void v_Married() {}
		public void v_Divorced() {}
		
		Model model = createModel();
		public Model createModel() {
			 
		    // Create a new, empty model
		    Model model = new Model();
		 
		    // Create vertexes (nodes)
		    //Vertex v_Start = new Vertex().setName("v_Start");

		 
		    // Create edges
		    //Edge e_Born = new Edge().setName("e_Born").setSourceVertex(v_Start).setTargetVertex(v_Single);

		 
		    // Add vertexes to the model
		    //model.addVertex(v_Start);



		 
		    // Add edges to the model
		    //model.addEdge(e_Born);

		 
		    return model;
		    
		    
		}
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
