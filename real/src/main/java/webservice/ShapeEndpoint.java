package webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.webservice.lib.*;;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/calculator";

    @Autowired
    private ShapeService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circle(@RequestPayload CircleAreaRequest request) {
        CircleAreaResponse res = new CircleAreaResponse();
        res.setArea(service.circle(request.getRadius()));
        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SquareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse square(@RequestPayload SquareAreaRequest request) {
        SquareAreaResponse res = new SquareAreaResponse();
        res.setArea(service.square(request.getSide()));
        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangle(@RequestPayload RectangleAreaRequest request) {
        RectangleAreaResponse res = new RectangleAreaResponse();
        res.setArea(service.rectangle(request.getLength(), request.getWidth()));
        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TriangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangle(@RequestPayload TriangleAreaRequest request) {
        TriangleAreaResponse res = new TriangleAreaResponse();
        res.setArea(service.triangle(request.getBase(), request.getHeight()));
        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ParallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogram(@RequestPayload ParallelogramAreaRequest request) {
        ParallelogramAreaResponse res = new ParallelogramAreaResponse();
        res.setArea(service.parallelogram(request.getBase(), request.getHeight()));
        return res;
    }
}