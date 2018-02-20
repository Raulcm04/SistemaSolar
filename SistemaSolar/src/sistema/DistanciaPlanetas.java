package sistema;

import java.awt.Color;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


public class DistanciaPlanetas extends TransformGroup {
 Point3f posiciones[];

    public DistanciaPlanetas(RotacionPlaneta rotacion, float distancia) {
        super();
        Transform3D transform3D = new Transform3D();
        transform3D.setTranslation(new Vector3f(0.0f, 0.0f, distancia));
      
        this.setTransform(transform3D);
        this.addChild(rotacion);
    }

    public DistanciaPlanetas(RotacionPlaneta rotacion, Vector3f vector) {
        super();
        Transform3D transform3D = new Transform3D();
        transform3D.setTranslation(vector);
        this.setTransform(transform3D);
        this.addChild(rotacion);
    }
    
     public TransformGroup curvas (float inicio, float ancho)
    {
        TransformGroup curva= new TransformGroup();
        int puntos []={360};
        LineStripArray coordenadas= new LineStripArray(puntos[0], LineStripArray.COORDINATES | LineStripArray.COLOR_3, puntos);
        posiciones= new Point3f[coordenadas.getValidVertexCount()];
        float x=0, y=0, z=0;
        int cont=0;
        for (int i = 0; i < 360; i++)
        {
            float  rad= (float)Math.toRadians(i);
            x=(float)(ancho*Math.cos(rad));
            z=(float)(ancho*Math.sin(rad));
            coordenadas.setCoordinate(cont, new Point3f(x, y, z));
            coordenadas.setColor(cont, new Color3f(Color.WHITE));
            posiciones[cont]=new Point3f(x, y, z);
            cont++;
            
            
        }
        Shape3D s3d= new Shape3D(coordenadas);
        curva.addChild(s3d);
        return curva;
    }

}
