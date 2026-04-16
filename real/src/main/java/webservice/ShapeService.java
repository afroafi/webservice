package webservice;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public double circle(double r) { return Math.PI * r * r; }
    public double square(double s) { return s * s; }
    public double rectangle(double l, double w) { return l * w; }
    public double triangle(double b, double h) { return 0.5 * b * h; }
    public double parallelogram(double b, double h) { return b * h; }
}