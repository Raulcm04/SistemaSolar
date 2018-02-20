package sistema;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;

public class TraslacionPlaneta extends TransformGroup {

    public static final int ROTACION_INFINITA = -1;
    public static final long GIRO_UNO = 1;   
    public static final long GIRO_MUY_RAPIDO = 3000;
    public static final long GIRO_RAPIDO = 5000;
    public static final long GIRO_NORMAL = 15000;
    public static final long GIRO_LENTO = 100000;
   

    public TraslacionPlaneta(DistanciaPlanetas distanciaPlaneta, long giro) {
        super();
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        RotationInterpolator interpolator = new RotationInterpolator(new Alpha(ROTACION_INFINITA, giro), this);
      
        interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1.0));
       
                
                
         
        
        this.addChild(interpolator);
        this.addChild(distanciaPlaneta);
        
    }
}
