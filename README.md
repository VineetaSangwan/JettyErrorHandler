JettyErrorHandler
=================

Following are the steps for configuring custom error handler for jetty version- 9.1.1

Custom error handler for jetty server errors.

Copy the jar file to ${JETTY.HOME}/lib/ext/


Copy the following to jetty.xml in the <Configure> tag:

                <Call name="addBean">
                                <Arg>
                                                <New class="com.mmt.handler.CustomErrorHandler"/>
                                </Arg>
                </Call>
                
Remove the code given below from the element <Set name="handler"> :

           <Item>
             <New id="DefaultHandler" class="org.eclipse.jetty.server.handler.DefaultHandler"/>
           </Item>


