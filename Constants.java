public class Constants {
        public static final boolean[][][] testMatrixes = {
                        {
                                        { false, false, false },
                                        { true, false, true }, // -
                                        { false, false, false }
                        },
                        {
                                        { false, true, false },
                                        { false, false, false }, // |
                                        { false, true, false}
                        },
                        {
                                        { true, false, true },
                                        { false, false, false }, // \
                                        { false, false, true }
                        },
                        {
                                        { false, false, true },
                                        { false, false, false }, // /
                                        { true, false, false }
                        }
        };
        public static final int[][][] testMatrixPositions = {
                        {
                                        { 0, -1 }, { 0, 1 }
                        },
                        {
                                        { -1, 0 }, { 1, 0 }
                        },
                        {
                                        { -1, 1 }, { 1, -1 }
                        },
                        {
                                        { -1, -1 }, { 1, 1 }
                        }

        };

}
