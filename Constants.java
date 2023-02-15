public class Constants {
        public static final int[][][] testMatrixes = {
                        {
                                        { 0, 0, 0 },
                                        { 1, 0, 1 }, // -
                                        { 0, 0, 0 }
                        },
                        {
                                        { 0, 1, 0 },
                                        { 0, 0, 0 }, // |
                                        { 0, 1, 0 }
                        },
                        {
                                        { 1, 0, 0 },
                                        { 0, 0, 0 }, // \
                                        { 0, 0, 1 }
                        },
                        {
                                        { 0, 0, 1 },
                                        { 0, 0, 0 }, // /
                                        { 1, 0, 0 }
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
