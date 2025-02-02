package engine.components;

import math.Vector3f;
import workspace.ui.Graphics;

/**
 * Represents a transformation in 3D space, encapsulating position, rotation, and scale. Implements
 * the Component interface.
 *
 * <p>The {@code Transform} class provides functionality to manipulate and apply transformations
 * such as translation, rotation, and scaling to objects or nodes in a 3D scene. It acts as a helper
 * utility to represent and modify the spatial properties of a 3D object or a scene node.
 *
 * <p>The transformations are defined by:
 *
 * <ul>
 *   <li><b>Position:</b> The location of the object in 3D space.
 *   <li><b>Rotation:</b> The orientation of the object around the X, Y, and Z axes.
 *   <li><b>Scale:</b> The size multiplier along the X, Y, and Z axes.
 * </ul>
 *
 * <p>This class provides methods for applying transformations to a rendering context, modifying
 * transformations incrementally, and setting transformation properties explicitly.
 *
 * @see Vector3f
 * @see Graphics
 */
public class Transform extends AbstractComponent {

  /** The position of this transform in 3D space. */
  private Vector3f position;

  /** The rotation (in radians) of this transform around the X, Y, and Z axes. */
  private Vector3f rotation;

  /** The scaling factors along the X, Y, and Z axes. */
  private Vector3f scale;

  /**
   * Constructs a new {@code Transform} with default position, rotation, and scale values.
   *
   * <p>The default position is set to (0, 0, 0), the default rotation is (0, 0, 0), and the default
   * scale is (1, 1, 1).
   */
  public Transform() {
    this.position = new Vector3f();
    this.rotation = new Vector3f();
    this.scale = new Vector3f(1, 1, 1);
  }

  /**
   * Applies this transformation to the given graphics context.
   *
   * <p>This method translates the context to the object's position, applies rotations around the X,
   * Y, and Z axes, and scales the object using the defined scale values.
   *
   * @param g The graphics context to which this transformation is applied.
   */
  public void apply(Graphics g) {
    g.scale(scale.x, scale.y, scale.z); // Scale first
    g.rotateX(rotation.x); // Then rotate
    g.rotateY(rotation.y);
    g.rotateZ(rotation.z);
    g.translate(position.x, position.y, position.z); // Translate last
  }

  /**
   * Translates this transformation by the given delta vector.
   *
   * <p>This modifies the position of the transform by adding the provided vector to the current
   * position.
   *
   * @param delta The vector representing the change in position.
   */
  public void translate(Vector3f delta) {
    this.position.addLocal(delta);
  }

  /**
   * Rotates this transformation by the given delta vector (in radians).
   *
   * <p>This modifies the rotation of the transform by adding the provided vector's values to the
   * current rotation.
   *
   * @param delta The vector representing the change in rotation (in radians).
   */
  public void rotate(Vector3f delta) {
    this.rotation.addLocal(delta);
  }

  /**
   * Rotates this transformation by the given delta values for each axis (in radians).
   *
   * @param x The change in rotation around the X-axis (in radians).
   * @param y The change in rotation around the Y-axis (in radians).
   * @param z The change in rotation around the Z-axis (in radians).
   */
  public void rotate(float x, float y, float z) {
    this.rotation.addLocal(x, y, z);
  }

  /**
   * Scales this transformation by the provided scaling factors.
   *
   * <p>This modifies the scale of the transform by multiplying the current scale values by the
   * provided factors.
   *
   * @param factor The vector representing the scale factors to apply along each axis.
   */
  public void scale(Vector3f factor) {
    this.scale.multLocal(factor);
  }

  /**
   * Retrieves a copy of the position vector.
   *
   * @return A new Vector3f instance representing the current position.
   */
  public Vector3f getPosition() {
    return new Vector3f(position);
  }

  /**
   * Sets the position of this transform to a specific value.
   *
   * @param position The new position vector to set. Must not be null.
   * @throws IllegalArgumentException if the provided vector is null.
   */
  public void setPosition(Vector3f position) {
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be null.");
    }
    this.position.set(position);
  }

  /**
   * Sets the position of this transform to the specified coordinates.
   *
   * <p>This method updates the position vector to the provided (x, y, z) values, effectively moving
   * the object to the given location in 3D space.
   *
   * @param x The X-coordinate of the new position.
   * @param y The Y-coordinate of the new position.
   * @param z The Z-coordinate of the new position.
   */
  public void setPosition(float x, float y, float z) {
    this.position.set(x, y, z);
  }

  /**
   * Retrieves a copy of the rotation vector.
   *
   * @return A new Vector3f instance representing the current rotation.
   */
  public Vector3f getRotation() {
    return new Vector3f(rotation);
  }

  /**
   * Sets the rotation of this transform to a specific value.
   *
   * @param rotation The new rotation vector (in radians) to set. Must not be null.
   * @throws IllegalArgumentException if the provided vector is null.
   */
  public void setRotation(Vector3f rotation) {
    if (rotation == null) {
      throw new IllegalArgumentException("Rotation cannot be null.");
    }
    this.rotation.set(rotation);
  }

  /**
   * Sets the rotation of this transform to the specified angles in radians.
   *
   * <p>This method updates the rotation vector to the provided (rx, ry, rz) values, which represent
   * the rotation of the object around the X, Y, and Z axes, respectively.
   *
   * @param rx The rotation angle around the X-axis, in radians.
   * @param ry The rotation angle around the Y-axis, in radians.
   * @param rz The rotation angle around the Z-axis, in radians.
   */
  public void setRotation(float rx, float ry, float rz) {
    this.rotation.set(rx, ry, rz);
  }

  /**
   * Retrieves a copy of the scale vector.
   *
   * @return A new Vector3f instance representing the current scale.
   */
  public Vector3f getScale() {
    return new Vector3f(scale);
  }

  /**
   * Sets the scale of this transform to a specific value.
   *
   * @param scale The new scale vector to set. Must not be null.
   * @throws IllegalArgumentException if the provided vector is null.
   */
  public void setScale(Vector3f scale) {
    if (scale == null) {
      throw new IllegalArgumentException("Scale cannot be null.");
    }
    this.scale.set(scale);
  }

  /**
   * Sets the scale of this transform to the specified scale factors along each axis.
   *
   * <p>This method updates the scale vector to the provided (sx, sy, sz) values, allowing the
   * object to be scaled uniformly or non-uniformly along the X, Y, and Z axes.
   *
   * @param sx The scale factor along the X-axis.
   * @param sy The scale factor along the Y-axis.
   * @param sz The scale factor along the Z-axis.
   */
  public void setScale(float sx, float sy, float sz) {
    this.scale.set(sx, sy, sz);
  }

  /**
   * Retrieves the forward direction of the transform, based on its current rotation.
   *
   * <p>The forward direction is calculated using the rotation values and represents the vector that
   * points in the direction the object is facing.
   *
   * @return A normalized {@link Vector3f} representing the forward direction of the object.
   */
  public Vector3f getForward() {
    float cosY = (float) Math.cos(rotation.y);
    float sinY = (float) Math.sin(rotation.y);
    float cosX = (float) Math.cos(rotation.x);
    float sinX = (float) Math.sin(rotation.x);

    return new Vector3f(cosY * cosX, sinX, sinY * cosX).normalizeLocal();
  }

  /**
   * Retrieves the right direction of the transform, based on its current rotation.
   *
   * <p>The right direction is calculated using the rotation values and represents the vector that
   * points to the right of the object.
   *
   * @return A normalized {@link Vector3f} representing the right direction of the object.
   */
  public Vector3f getRight() {
    float cosY = (float) Math.cos(rotation.y);
    float sinY = (float) Math.sin(rotation.y);

    return new Vector3f(-sinY, 0, cosY).normalizeLocal();
  }

  /**
   * Sets the forward direction of this transform.
   *
   * <p>This method calculates the rotation angles (pitch and yaw) needed to make the object face
   * the given forward direction and updates the rotation vector accordingly.
   *
   * @param forward The desired forward direction as a normalized vector.
   */
  public void setForward(Vector3f forward) {
    if (forward == null || forward.length() == 0) {
      throw new IllegalArgumentException("Forward vector cannot be null or zero-length.");
    }

    // Calculate yaw (rotation around the Y-axis) and pitch (rotation around the X-axis)
    float yaw = (float) Math.atan2(forward.z, forward.x);
    float pitch =
        (float) Math.atan2(forward.y, Math.sqrt(forward.x * forward.x + forward.z * forward.z));

    // Update the rotation vector
    this.rotation.set(pitch, yaw, 0);
  }

  @Override
  public void onUpdate(float tpf) {}

  @Override
  public void onAttach() {}

  @Override
  public void onDetach() {}
}
