package com.github.ollime.ferretmod.entity.client;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class FerretAnimations {
    public static final Animation WALKING = Animation.Builder.create(1.5F)
            .looping()
            .addBoneAnimation(
                    "root",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "head",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.375F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.125F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "right_front_leg",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "right_front_leg",
                    new Transformation(
                            Transformation.Targets.TRANSLATE,
                            new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "left_front_leg",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "left_front_leg",
                    new Transformation(
                            Transformation.Targets.TRANSLATE,
                            new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "left_hind_leg",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.375F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(-20.4F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                    )
            )
            .addBoneAnimation(
                    "left_back_leg",
                    new Transformation(
                            Transformation.Targets.TRANSLATE,
                            new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.21F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.21F, 0.0F), Transformation.Interpolations.LINEAR)
                    )
            )
            .addBoneAnimation(
                    "right_back_leg",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.625F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
            .addBoneAnimation(
                    "right_back_leg",
                    new Transformation(
                            Transformation.Targets.TRANSLATE,
                            new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                    )
            )
//            .addBoneAnimation(
//                    "left_ear",
//                    new Transformation(
//                            Transformation.Targets.ROTATE,
//                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
//                    )
//            )
//            .addBoneAnimation(
//                    "right_ear",
//                    new Transformation(
//                            Transformation.Targets.ROTATE,
//                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
//                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
//                    )
//            )
            .addBoneAnimation(
                    "tail",
                    new Transformation(
                            Transformation.Targets.ROTATE,
                            new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.94102F, -8.42106F, 20.94102F), Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.94102F, 8.42106F, -20.94102F), Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5F, AnimationHelper.createRotationalVector(15.94102F, -8.42106F, 20.94102F), Transformation.Interpolations.CUBIC)
                    )
            )
            .build();
}
