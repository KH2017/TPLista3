/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.composite.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Joao Pereira
 * 
 */
public abstract class CompositeShape extends Shape {

	List<Shape> shapes;

	public CompositeShape() {
		this.shapes = createShapesList();
	}
	
	@Override
	public CompositeShape asComposite() {
		return this;
	}

	@Override
	public void move(int xIncrement, int yIncrement) {
		this.setX(this.getX() + xIncrement);
		this.setY(this.getY() + yIncrement);
		
		for(Shape shape:shapes){
			shape.move(xIncrement , yIncrement);
		}
	}
	
	
	/**
	 * Remove a shape from this shape childrens
	 * 
	 * @param shape
	 *            the shape to remove
	 * @return true if the shape was present and was removed, false if the shape
	 *         was not present
	 */
	public boolean removeShape(Shape shape) {
		if(shapes.remove(shape))
			return true;
		else
			return false;

	}

	/**
	 * Return the total shapes count in case this is a composite
	 * 
	 * @return the total count of shapes if the shape is composite. -1 otherwise
	 */
	public int getShapeCount() {
		return shapes.size();

	}

	/**
	 * Add a shape to this shape.
	 * 
	 * @param shape
	 *            The shape to add
	 * @throws ShapeDoesNotSupportChildren
	 *             if this shape is not a composite
	 */
	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public List<Shape> getShapes() {
		return this.shapes;

	}

	/**
	 * @param circle
	 * @return
	 */
	public List<Shape> getShapesByType(ShapeType circle) {
		List<Shape> aaa = createShapesList();
		for(Shape shape:shapes)
			if(shape.getType() == circle)
				aaa.add(shape);
		
		return aaa;
	}

	/**
	 * Return all shapes that are leafs in the tree
	 * 
	 * @return
	 */
	public List<Shape> getLeafShapes() {
		List<Shape> aaa = createShapesList();
		for(Shape shape:shapes)
			if(shape.asComposite() == null)
				aaa.add(shape);
		
		return aaa;
	}

	/**
	 * Factory method for the list of children of this shape
	 * 
	 * @return
	 */
	protected List<Shape> createShapesList() {
		return new ArrayList<Shape>();
	}
}
