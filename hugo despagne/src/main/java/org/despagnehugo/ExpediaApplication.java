package org.despagnehugo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.despagnehugo.api.DropWizardExpediaExceptionMapper;
import org.despagnehugo.data.FlightDAO;
import org.despagnehugo.health.GenericHealthCheck;
import org.despagnehugo.resources.ExpediaResource;

public class ExpediaApplication extends Application<ExpediaConfiguration>
{
    public static void main(String[] args) throws Exception {
        new ExpediaApplication().run(args);
    }

    @Override
    public String getName() {
        return "Expedia";
    }

    @Override
    public void initialize(Bootstrap<ExpediaConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ExpediaConfiguration configuration, Environment environment) {
        final FlightDAO flightDAO = new FlightDAO();
        final ExpediaResource resource = new ExpediaResource(flightDAO);
        final GenericHealthCheck healthCheck = new GenericHealthCheck();
        environment.healthChecks().register("generic", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(new DropWizardExpediaExceptionMapper());
    }

}
