package com.pger.de.visitor.kpi;

/**
 * Created by Tom.
 */
public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);

}
