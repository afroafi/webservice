package webservice.real;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public double circle(double r) {

        validatePositive(r, "Radius");
        return Math.PI * r * r;
    }

    public double square(double s) {

        validatePositive(s, "Side");
        return s * s;
    }

    public double rectangle(double l, double w) {

        validatePositive(l, "Length");
        validatePositive(w, "Width");
        return l * w;
    }

    public double triangle(double b, double h) {

        validatePositive(b, "Base");
        validatePositive(h, "Height");
        return 0.5 * b * h;
    }

    public double parallelogram(double b, double h) {

        validatePositive(b, "Base");
        validatePositive(h, "Height");
        return b * h;
    }

    private void validatePositive(double value, String fieldName) {

        if (value < 0) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be negative"
            );
        }
    }
}