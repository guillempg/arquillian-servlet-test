package com.tad.arqdevguide.chp3.servlet;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tad.arqdevguide.chp3.HelloServlet;
import org.jboss.arquillian.container.test.api.TargetsContainer;

@RunWith(Arquillian.class)
public class HelloServletTest {
	
    @Deployment
    @TargetsContainer("tomcat")
    public static Archive<?> createTestArchiveProperties() {
        WebArchive wa = ShrinkWrap.create(WebArchive.class, "test.war")
                        .addClass(HelloServlet.class).addAsWebInfResource("web.xml");
        return wa;
    }

    @Test
    public void testGetText() throws Exception {
        URL url = new URL("http://localhost:8080/test/hello");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String result = br.readLine();
        String expected = "Hello, World!";
        assertEquals(expected, result);
    }
}
